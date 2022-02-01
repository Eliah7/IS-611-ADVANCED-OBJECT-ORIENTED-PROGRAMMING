package home.services;

import home.domain.Member;
import home.repository.MemberRepository;

import java.util.List;

public class MemberService {
    public static final String PAY = "Pay";
    public static final String Delete = "Delete";
    public static final String Edit = "Edit";
    public static final String VIEW_CONTRIBUTIONS = "View Contributions";

    private  MemberRepository memberRepository;


    public MemberService(){
        memberRepository = new MemberRepository();
    }


    public List<Member> getAllMembers() throws Exception{
        return memberRepository.getAll();
    }

    public boolean deleteMember(Member data) throws Exception{
        return this.memberRepository.delete(data);
    }

    public boolean addMember(Member data) throws Exception{
        return this.memberRepository.add(data);
    }
}
