
public class basic{
    public enum Days{
        // this value | action of days take for example
        Monday("Shiv ji") ,Tuesday("Ram JI") , Wednesday("Radha Ji") , Thursday("Krishn ji") , Friday("Hariwans ji") , Saturday("Hanuman Ji") , Sunday("Durga ji") ;

        private String action;

        public String getAction(){
            return this.action;
        }
        private Days(String action){
            this.action = action;
        }
    }

    public static void main(String[] a){ 
        
        Days week2 = Days.valueOf("Monday");
        System.out.println(week2 + " -> " + week2.getAction());

        week2 = Days.valueOf("Tuesday");
        System.out.println(week2 + " -> " + week2.getAction());

        week2 = Days.valueOf("Wednesday");
        System.out.println(week2 + " -> " + week2.getAction());

        week2 = Days.valueOf("Thursday");
        System.out.println(week2 + " -> " + week2.getAction());

        week2 = Days.valueOf("Friday");
        System.out.println(week2 + " -> " + week2.getAction());

        week2 = Days.valueOf("Saturday");
        System.out.println(week2 + " -> " + week2.getAction());

        week2 = Days.valueOf("Sunday");
        System.out.println(week2 + " -> " + week2.getAction());
        
        
        System.out.println("\nenum print using loop\n");
        
        for(Days i : week2.values() ){
            System.out.println(i + " -> " + i.getAction());
        }

    }

}
