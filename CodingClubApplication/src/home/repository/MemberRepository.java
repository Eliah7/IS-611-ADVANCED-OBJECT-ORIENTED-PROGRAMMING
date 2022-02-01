package home.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import home.domain.Member;
import home.domain.MonthlyPaymentList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository extends Repository<Member>{
    public String COLLECTION_NAME = "members";

    public MemberRepository(){
        super();
    }

    @Override
    public List<Member> getAll() throws Exception {
        ApiFuture<QuerySnapshot> query = this.databaseConnector.db.collection(COLLECTION_NAME).get();

        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        List<Member> members = new ArrayList<>();
        for (QueryDocumentSnapshot document : documents) {
            Member member = new Member();

            if (document.contains("memberName")){
                member.setMemberName(document.getString("memberName"));
            }

            if (document.contains("membershipNumber")){
                member.setMembershipNumber(document.getString("membershipNumber"));
            }

            if (document.contains("monthlyPaymentList")){
                member.setMonthlyPaymentList((MonthlyPaymentList) document.get("monthlyPaymentList;"));
            }

            members.add(member);
        }

        return members;
    }

    @Override
    public boolean add(Member element) throws Exception {
        DocumentReference docRef = this.databaseConnector.db.collection(COLLECTION_NAME).document(element.getMembershipNumber());

        Map<String, Object> data = new HashMap<>();
        data.put("memberName", element.getMemberName());
        data.put("membershipNumber", element.getMembershipNumber());
        data.put("monthlyPaymentList", element.getMonthlyPaymentList());

        System.out.println("Data to send" +  data.toString());
        ApiFuture<com.google.cloud.firestore.WriteResult> result = docRef.set(data);
        result.get();
        return result.isDone();
    }

    @Override
    public boolean delete(Member member) throws Exception{
        ApiFuture<WriteResult> writeResult = this.databaseConnector.db.collection(COLLECTION_NAME).document(member.getMembershipNumber()).delete();
        System.out.println("Deleted at time : " + writeResult.get().getUpdateTime());
        return writeResult.isDone();
    }

    @Override
    public int size() {
        return 0;
    }
}
