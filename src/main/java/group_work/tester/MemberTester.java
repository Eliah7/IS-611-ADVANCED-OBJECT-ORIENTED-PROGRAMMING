package group_work.tester;

import group_work.Member;
import group_work.MonthlyPayment;
import group_work.MonthlyPaymentList;

import java.util.ArrayList;
import java.util.List;

public class MemberTester {
    public static void main(String[] args) {
        Member member, member1, member2;
        MonthlyPaymentList paymentList;
        MonthlyPayment payment ;
        try {
            member = new Member();
            member1 = new Member("123");

            paymentList = new MonthlyPaymentList();
            paymentList.add(new MonthlyPayment(20000.0, 1));
            paymentList.add(new MonthlyPayment(40000.0, 2));
            paymentList.add(new MonthlyPayment(30000.0, 3));

            payment = new MonthlyPayment(50000.0, 4);


            member2 = new Member("12345", paymentList);
            System.out.println("MembershipNo:" + member.getMembershipNumber());
            System.out.println("MembershipNo1:" + member1.getMembershipNumber());
            System.out.print("Payemnt History: ");
            member2.displayPaymentHistory();

            member2.recordPayment(payment);
            member2.displayPaymentHistory();

            System.out.print(member2.getMonthlyPaymentList());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}