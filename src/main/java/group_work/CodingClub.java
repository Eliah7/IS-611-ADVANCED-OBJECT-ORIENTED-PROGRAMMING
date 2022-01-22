package group_work;

import java.util.Scanner;

/**
 * Coding Club class
 * @author: Group 2
 * @version 1.0
 */
public class CodingClubs {
    /**
     * attributes
     */
    public MemberList memberList;
    ClubManager clubManager;

    /**
     * Constructor
     */
    public CodingClubs() {
        this.clubManager = new ClubManager();
        this.memberList = new MemberList();
    }

    /**
     * Gets the member list
     * @return memberList
     */
    public MemberList getMemberList() {
        return memberList;
    }

    /**
     * Set the member list
     * @param memberList
     */
    public void setMemberList(MemberList memberList) {
        this.memberList = memberList;
    }

    /**
     * Gets the Club Manager
     * @return clubManager
     */
    public ClubManager getClubManager() {
        return clubManager;
    }

    /**
     * Sets the Club Manager
     * @param clubManager
     */
    public void setClubManager(ClubManager clubManager) {
        this.clubManager = clubManager;
    }

    /**
     * Add new member to the list
     * @param member
     */
    public void addMember(Member member){
        this.setMemberList(this.clubManager.addMember(member, this.memberList));
    }

    /**
     * Delete member from the list
     * @param member
     */
    public void deleteMember(Member member){
        this.setMemberList(this.clubManager.deleteMember(member, this.memberList));
    }

    /**
     * List all members of the club
     */
    public void listMembers(){
        this.clubManager.listAllMembers(this.memberList);
    }

    /**
     * Add the new monthly payment record for a member
     * @param member
     * @param monthlyPayment
     */
    public void recordPaymentForMember(Member member, MonthlyPayment monthlyPayment){
        if(this.memberList.members.stream().anyMatch(member1 -> member1.getMembershipNumber().equalsIgnoreCase(member.getMembershipNumber()))){
            System.out.println("Updating member payment history");
            this.memberList.members.stream()
                    .filter(member1 -> member1.getMembershipNumber().equalsIgnoreCase(member.getMembershipNumber()))
                    .findAny()
                    .get().recordPayment(monthlyPayment);
        } else {
            System.out.println("Member does not exist");
        }
    }

    /**
     * Display payment history for a member
     * @param member
     */
    public void paymentHistoryForMember(Member member){
        this.memberList.getMember(member).displayPaymentHistory();
    }



}

