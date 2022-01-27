package home.domain.tester;

import home.domain.Member;
import home.domain.MemberList;

public class MemberListTester {
    public static void main(String[] args) {

        try {
            Member member1 = new Member("123");
            Member member2 = new Member("456");
            Member member3 = new Member("789");

            MemberList memberList = new MemberList();
            memberList.addMember(member1);
            memberList.addMember(member2);
            memberList.addMember(member3);

            System.out.println(memberList);

//            System.out.println(memberList.getMember(1));
//            System.out.println(memberList.getMember(10));
//            System.out.println(memberList.getMember(member1));
//            System.out.println(memberList.getMemberByMembershipNo("123"));
//            System.out.println(memberList.getMemberByMembershipNo("12345"));

            memberList.deleteMember(member1);
            memberList.deleteMember("789");
            System.out.println(memberList);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
