package home.domain;



public class ClubManager {

    /**
     * Adds a member to the member list
     * @param member
     * @param memberList
     * @return
     */
    public MemberList addMember(Member member, MemberList memberList){
        memberList.addMember(member);
        return memberList;
    }

    /**
     * Remove member from the list using Index
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
     * Remove member from the list using member object
     * @param member
     * @param memberList
     * @return
     */
    public MemberList deleteMember(Member member, MemberList memberList){
        memberList.deleteMember(member);
        return  memberList;
    }

    /**
     * Display list of members
     * @param memberList
     */
    public void listAllMembers(MemberList memberList){
        System.out.println(memberList);
    }

    /**
     * Adds member payment for  a certain month
     * @param payment
     * @param member
     * @return
     */
    public boolean recordPayment(MonthlyPayment payment, Member member){
        return member.recordPayment(payment);
    }

    /**
     * Display member payment history
     * @param member
     */
    public void displayMemberPaymentHistory(Member member){
        member.displayPaymentHistory();
    }

}
