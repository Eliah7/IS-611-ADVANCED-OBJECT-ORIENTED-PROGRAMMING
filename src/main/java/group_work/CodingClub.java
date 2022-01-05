package group_work;

import java.util.Scanner;

public class CodingClub {
    public MemberList memberList;
    ClubManager clubManager;

    public CodingClub() {
        this.clubManager = new ClubManager();
        this.memberList = new MemberList();
    }

    public MemberList getMemberList() {
        return memberList;
    }

    public void setMemberList(MemberList memberList) {
        this.memberList = memberList;
    }

    public ClubManager getClubManager() {
        return clubManager;
    }

    public void setClubManager(ClubManager clubManager) {
        this.clubManager = clubManager;
    }


    public void addMember(Member member){
        this.setMemberList(this.clubManager.addMember(member, this.memberList));
    }

    public void deleteMember(Member member){
        this.setMemberList(this.clubManager.deleteMember(member, this.memberList));
    }

    public void listMembers(){
        this.clubManager.listAllMembers(this.memberList);
    }

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

    public void paymentHistoryForMember(Member member){
        this.memberList.getMember(member).displayPaymentHistory();
    }



}

