package group_work;

import java.util.ArrayList;

public class MemberList {
     // attributes
     public ArrayList<Member> members;

     /**
      * Constructor
      */
     public MemberList() {
          this.members = new ArrayList<>();
     }

     /**
      *
      * @param members
      */
     public MemberList(ArrayList<Member> members) {
          this.members = members;
     }

     public boolean memberIsInList(Member member){
          return this.members.stream().anyMatch(member1 -> member.getMembershipNumber().compareToIgnoreCase(member1.getMembershipNumber()) == 0);
     }
     public int size(){
          return this.members.size();
     }

     /*
      *
      * @param member
      * @return
      */
     public Boolean deleteMember(Member member1){
          String memberShipNo = member1.getMembershipNumber();
          if(this.members.stream().anyMatch(member -> member.getMembershipNumber().equalsIgnoreCase(memberShipNo))){
               //System.out.println("Member to be deleted");
               Member memberObj = this.members.stream()
                       .filter(member -> member.getMembershipNumber().equalsIgnoreCase(memberShipNo))
                       .findAny()
                       .get();
               return this.members.remove(memberObj);
          } else {
               return false;
          }
     }

     public Boolean deleteMember(String memberShipNo){
          if(this.members.stream().anyMatch(member -> member.getMembershipNumber().equalsIgnoreCase(memberShipNo))){
               //System.out.println("Member to be deleted");
               Member memberObj = this.members.stream()
                       .filter(member -> member.getMembershipNumber().equalsIgnoreCase(memberShipNo))
                       .findAny()
                       .get();
               return this.members.remove(memberObj);
          } else {
               return false;
          }

     }
     /**
      *
      * @param member
      * @return
      */
     public Boolean addMember(Member member){
          if (!memberIsInList(member)){
             return this.members.add(member);}
          else{
              return false;
          }
     }


     /**
      *
      * @param index
      * @return
      */
     public Member getMember(int index){
          return members.get(index);
     }

     public Member getMember(Member member1){
          return this.members.stream().filter(member -> member1.getMembershipNumber().compareToIgnoreCase(member.getMembershipNumber()) == 0).findFirst().get();
     }

     public Member getMemberByMembershipNo(String membershipNo){
          return this.members.stream()
                  .filter(member -> member.getMembershipNumber().compareToIgnoreCase(membershipNo) == 0)
                  .findFirst()
                  .get();
     }
     @Override
     public String toString() {
          String list = "";
          for (Member member: this.members) {
               list += '\n' + member.toString();
          }
          list += "\n";

          return list;
     }
}
