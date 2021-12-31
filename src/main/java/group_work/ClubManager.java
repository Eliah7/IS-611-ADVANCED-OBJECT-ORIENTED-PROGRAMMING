package group_work;

public class ClubManager {

    /**
     *
     * @param member
     * @param memberList
     * @return
     */
    public MemberList addMember(Member member, MemberList memberList){
        memberList.addMember(member);
        return memberList;
    }

    /**
     *
     * @param memberIndex
     * @param memberList
     * @return
     */
    public MemberList deleteMember(int memberIndex, MemberList memberList){
        if(memberList.size() <= memberIndex){
            memberList.deleteMember(memberList.getMember(memberIndex));
        }
        return  memberList;
    }

    /**
     *
     * @param member
     * @param memberList
     * @return
     */
    public MemberList deleteMember(Member member, MemberList memberList){
        memberList.deleteMember(member);
        return  memberList;
    }

    /**
     *
     * @param memberList
     */
    public void listAllMembers(MemberList memberList){
        System.out.println(memberList);
    }

    /**
     *
     * @param payment
     * @param member
     * @return
     */
    public boolean recordPayment(MonthlyPayment payment, Member member){
        return member.recordPayment(payment);
    }

    /**
     *
     * @param member
     */
    public void displayMemberPaymentHistory(Member member){
        member.displayPaymentHistory();
    }

}
