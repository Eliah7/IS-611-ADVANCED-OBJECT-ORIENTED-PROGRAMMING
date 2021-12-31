package group_work;

import java.util.ArrayList;

public class MemberList {
     // attributes
     private ArrayList<Member> members;

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

     public int size(){
          return this.members.size();
     }

     /**
      *
      * @param member
      * @return
      */
     public Boolean deleteMember(Member member){
          return this.members.remove(member);
     }

     /**
      *
      * @param member
      * @return
      */
     public Boolean addMember(Member member){
          return this.members.add(member);
     }


     /**
      *
      * @param index
      * @return
      */
     public Member getMember(int index){
          return members.get(index);
     }


     @Override
     public String toString() {
          String list = "MemberList { ";
          for (Member member: this.members) {
               list += '\t' + member.toString();
          }
          list += "\n }";

          return list;
     }
}
