package group_work.tester;

import group_work.CodingClub;
import group_work.Member;
import group_work.MonthlyPayment;

import java.util.Scanner;

public class CodingClubTester {
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
