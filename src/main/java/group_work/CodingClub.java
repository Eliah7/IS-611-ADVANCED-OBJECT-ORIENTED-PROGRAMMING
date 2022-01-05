package group_work;

import java.util.Scanner;

public class CodingClub {
    private MemberList memberList;
    private ClubManager clubManager;

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

    public static void main(String[] args) {
        CodingClub codingClub = new CodingClub();
        Scanner scanner = new Scanner(System.in);
        String choice;

        try {
            do {
                System.out.println();
                System.out.println("[1] ADD MEMBER");
                System.out.println("[2] DELETE MEMBER");
                System.out.println("[3] LIST MEMBERS");
                System.out.println("[4] RECORD PAYMENT FOR MEMBER");
                System.out.println("[5] PAYMENT HISTORY FOR MEMBER");
                System.out.println("[6] Quit");
                System.out.println();
                System.out.print("Enter a choice [1-6]: ");

                choice = scanner.next();
                System.out.println();

                switch (choice) {
                    case "1": {
                        // request user details of member
                        System.out.println("ENTER THE MEMBERSHIP NO OF THE MEMBER");
                        String membershipNo = scanner.next();
                        Member member = new Member(membershipNo);
                        codingClub.addMember(member);
                        break;
                    }

                    case "2": {
                        codingClub.listMembers();
                        System.out.println("ENTER THE MEMBERSHIP NO OF THE MEMBER");
                        String membershipNo = scanner.next();
                        Member member = new Member(membershipNo);
                        if (codingClub.memberList.memberIsInList(member)) {
                            System.out.println("MEMBER IS IN LIST");
                            codingClub.deleteMember(member);
                        } else {
                            System.out.println("MEMBER IS NOT PRESENT IN THE LIST");
                        }
                        break;
                    }
                    case "3": {
                        codingClub.listMembers();
                        break;
                    }
                    case "4": {
                        System.out.println("ENTER THE MEMBERSHIP NO OF THE MEMBER");
                        String membershipNo = scanner.next();
                        Member member = new Member(membershipNo);

                        System.out.println("ENTER THE MONTH (1-12)");
                        int month = scanner.nextInt();

                        if (month <= 12 && month > 0) {
                            System.out.println("ENTER THE AMOUNT");
                            Double amount = scanner.nextDouble();
                            if(amount > 0) {
                                MonthlyPayment monthlyPayment = new MonthlyPayment(amount, month);
                                codingClub.recordPaymentForMember(member, monthlyPayment);
                            } else{
                                System.out.println("AMOUNT CAN NOT BE NEGATIVE OR ZERO");
                            }
                        } else {
                            System.out.println("MONTH HAS TO BE BETWEEN 1 AND 12");
                        }
                        break;
                    }
                    case "5": {
                        codingClub.listMembers();
                        System.out.println("ENTER THE MEMBERSHIP NO OF THE MEMBER");
                        String membershipNo = scanner.next();
                        Member member = new Member(membershipNo);
                        if (codingClub.memberList.memberIsInList(member)) {
                            codingClub.paymentHistoryForMember(member);
                        } else {
                            System.out.println("MEMBER IS NOT PRESENT IN THE LIST");
                        }
                        break;
                    }
                    case "6":
                        System.out.println("PROGRAM COMPLETE");
                        break;
                    default:
                        System.out.print("1-6 only");
                }
            } while (choice.compareToIgnoreCase("6") != 0);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

