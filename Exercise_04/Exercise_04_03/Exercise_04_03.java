/*
(Geography: estimate areas) Find the GPS locations for Atlanta, Georgia;
Orlando, Florida; Savannah, Georgia; and Charlotte, North Carolina from
www.gps-data-team.com/map/ and compute the estimated area enclosed by these
four cities. (Hint: Use the formula in Programming Exercise 4.2 to compute the
distance between two cities. Divide the polygon into two triangles and use the
formula in Programming Exercise 2.19 to compute the area of a triangle.)
*/

public class EX403_Geography_EstimateAreas {
   public static void main (String [] args){
            
       double latCharlotteR = Math.toRadians(35.2270869);
       double lonCharlotteR = Math.toRadians(-80.8431267);
       double latSavannahR = Math.toRadians(32.0835407);
       double lonSavannahR = Math.toRadians(-81.0998342);
       double latOrlandoR = Math.toRadians(28.5383355);
       double lonOrlandoR = Math.toRadians(-81.3792365);
       double latAtlantaR = Math.toRadians(33.7489954);
       double lonAtlantaR = Math.toRadians(-84.3879824);     
       
       final double radius = 6371.01;
       
       double a = radius * Math.acos(Math.sin(latCharlotteR) * Math.sin(latSavannahR) + Math.cos(latCharlotteR) * Math.cos(latSavannahR) * Math.cos(lonCharlotteR - lonSavannahR));
       double b = radius * Math.acos(Math.sin(latSavannahR) * Math.sin(latOrlandoR) + Math.cos(latSavannahR) * Math.cos(latOrlandoR) * Math.cos(lonSavannahR - lonOrlandoR));
       double c = radius * Math.acos(Math.sin(latOrlandoR) * Math.sin(latAtlantaR) + Math.cos(latOrlandoR) * Math.cos(latAtlantaR) * Math.cos(lonOrlandoR - lonAtlantaR));
       double d = radius * Math.acos(Math.sin(latAtlantaR) * Math.sin(latCharlotteR) + Math.cos(latAtlantaR) * Math.cos(latCharlotteR) * Math.cos(lonAtlantaR - lonCharlotteR));
       
       double j = radius * Math.acos(Math.sin(latAtlantaR) * Math.sin(latSavannahR) + Math.cos(latAtlantaR) * Math.cos(latSavannahR) * Math.cos(lonAtlantaR - lonSavannahR));
       
       double sT1 = (a + j + d) / 2;
       double sT2 = (b + j + c) / 2;
       
       double areaT1 = Math.sqrt((sT1 * (sT1 - a) * (sT1 - j) * (sT1 - d)));
       double areaT2 = Math.sqrt((sT2 * (sT2 - b) * (sT2 - j) * (sT2 - c)));
       
       double area = areaT1 + areaT2;
       
       System.out.printf("the estimated area enclosed by these four cities is %,5.3f square km", area);
       
   } 
}
