package home.domain;;

import java.util.ArrayList;

public class MemberList {
     /**
      * Atributes
      */
     public ArrayList<Member> members;

     /**
      * Constructor
      */
     public MemberList() {
          this.members = new ArrayList<>();
     }

     /**
      * Constructor
      * @param members
      */
     public MemberList(ArrayList<Member> members) {
          this.members = members;
     }

     /**
      * Check if a member is in member list
      * @param member
      * @return boolean
      */
     public boolean memberIsInList(Member member){
          return this.members.stream().anyMatch(member1 -> member.getMembershipNumber().compareToIgnoreCase(member1.getMembershipNumber()) == 0);
     }

     /**
      * Returns size of the member list
      * @return int
      */
     public int size(){
          return this.members.size();
     }

     /*
      * Remove member from the member list using member object
      * @param member
      * @return boolean
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

     /**
      * Remove member from the member list using membershipNumber
      * @param memberShipNo
      * @return boolean
      */
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
      * Adds new member to the list of members
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
      * Returns member using index
      * @param index
      * @return Member
      */
     public Member getMember(int index){
          return members.get(index);
     }

     /**
      * Returns member using Member object
      * @param member1
      * @return Member
      */
     public Member getMember(Member member1){
          return this.members.stream().filter(member -> member1.getMembershipNumber().compareToIgnoreCase(member.getMembershipNumber()) == 0).findFirst().get();
     }

     /**
      * Returns member using membership number
      * @param membershipNo
      * @return Member
      */
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
