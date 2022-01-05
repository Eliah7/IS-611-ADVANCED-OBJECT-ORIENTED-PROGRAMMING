package group_work.tester;

import group_work.ClubManager;
import group_work.Member;
import group_work.MemberList;
import group_work.MonthlyPayment;

import java.util.Scanner;

public class ClubManagerTester {
    public static void main(String[] args) {
        ClubManager clubManager = new ClubManager();
        Scanner scanner = new Scanner(System.in);
        MemberList memberList = new MemberList();

        String choice;
        do {
            System.out.println();
            System.out.println("[1] ADD MEMBER");
            System.out.println("[2] DELETE MEMBER");
            System.out.println("[3] LIST MEMBERS");
//            System.out.println("[4] RECORD PAYMENT FOR MEMBER");
//            System.out.println("[5] PAYMENT HISTORY FOR MEMBER");
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
                    memberList = clubManager.addMember(member, memberList);
                    break;
                }

                case "2": {
                    clubManager.listAllMembers(memberList);
                    System.out.println("ENTER THE MEMBERSHIP NO OF THE MEMBER");
                    String membershipNo = scanner.next();
                    Member member = new Member(membershipNo);
                    if (memberList.memberIsInList(member)) {
                        System.out.println("MEMBER IS IN LIST");
                        clubManager.deleteMember(member, memberList);
                    } else {
                        System.out.println("MEMBER IS NOT PRESENT IN THE LIST");
                    }
                    break;
                }
                case "3": {
                    clubManager.listAllMembers(memberList);
                    break;
                }
                case "4": {

                    break;
                }
                case "5": {

                    break;
                }
                case "6":
                    System.out.println("PROGRAM COMPLETE");
                    break;
                default:
                    System.out.print("1-6 only");
            }
        } while (choice.compareToIgnoreCase("6") != 0);
    }
}
