

public class Food {

    private String name, type, percentString;
    private int    proteins, carbs, fats, servingCalories;
    private double servings;
    private double totalProteins, totalCarbs, totalFats, totalCalories;
    private int proCals, carbCals, fatCals;
    private double perCarb, perProt, perFat;

    private boolean is404020;


    public static void main(String[] args) {
        Food bigMac = new Food("Big Mac", 34,46,25);
        System.out.println(bigMac);
        bigMac.getPercents();


    }
    public Food(String n, int p, int c, int f, int cal, double serv){
        name = n;
        proteins = p;
        carbs = c;
        fats = f;
        servingCalories = cal;
        servings = serv;
        totalCalories = servingCalories*servings;
        calcAll();
    }
    public Food(String n, int p, int c, int f, int cal){
        name = n;
        proteins = p;
        carbs = c;
        fats = f;
        servingCalories = cal;
        servings = 1;
        totalCalories = servingCalories*servings;
        calcAll();

    }
    public Food(String n, int p, int c, int f, double serv){
        name = n;
        proteins = p;
        carbs = c;
        fats = f;
        servingCalories = p*4 + c*4 + f*9;
        servings = serv;
        totalCalories = servingCalories*servings;
        calcAll();

    }

    public Food(String n, int p, int c, int f){
        name = n;
        proteins = p;
        carbs = c;
        fats = f;
        servingCalories = p*4 + c*4 + f*9;
        servings = 1;
        totalCalories = servingCalories;
        calcAll();

    }

    public Food(String n, String t, int p, int c, int f){
        name = n;
        type = t;
        proteins = p;
        carbs = c;
        fats = f;
        servingCalories = p*4 + c*4 + f*9;
        servings = 1;
        totalCalories = servingCalories;
        calcAll();

    }

    public Food(String n){
        name = n;
        proteins = 0;
        carbs = 0;
        fats = 0;
        servingCalories = 0;
        servings = 0;
        totalCalories = servingCalories;
        calcAll();

    }

    public String toString(){
        return name+": \n" +
                " - Food Type: "+ type +"\n" +
                " - Calories: "+ servingCalories +" cals\n" +
                " - Servings: "+ servings +" \n" +
                " - Proteins: "+proteins+"g \n" +
                " - Carbs: "+carbs+"g \n" +
                " - Fats: "+fats+"g \n" +
                " - Lean: "+is404020+"\n" +
                " - Ratio: "+percentString+"\n";
    }
    public void calcCalories(){
        proCals = proteins*4;
        carbCals = carbs*4;
        fatCals = fats*9;
        servingCalories = proCals + carbCals + fatCals;
    }
    public void calcTotals(){
        totalProteins = proCals * servings;
        totalCarbs = carbCals * servings;
        totalFats = fatCals * servings;
        totalCalories = servingCalories * servings;
    }



    public void calcPercents() {
        perProt = round(100 * totalProteins / totalCalories);
        perCarb = round(100 * totalCarbs / totalCalories);
        perFat = round(100 * totalFats / totalCalories);
        percentString = "P:"+Math.round(perProt)+"% C:"+ Math.round(perCarb)+"% F:"+Math.round(perFat)+"%";
    }

    public void calcAll(){
        calcCalories();
        calcTotals();
        calcPercents();
        is404020();
    }

    public void getPercents(){
        System.out.println(
                name+": \n" +
                        " - Total Calories: "+ servingCalories +" cals\n" +
                        " - Proteins: "+perProt+"%\n" +
                        " - Carbs: "+perCarb+"%\n" +
                        " - Fats: "+perFat+"%"
        );
    }



    public double round(double number){
        return (int)(number*100+0.5)/100.0;
    }

    public void is404020(){
        is404020 = (perFat <= 25 &&
                perCarb <= 65 &&
                perProt >= 30) || perProt >= 60;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercentString() {
        return percentString;
    }

    public void setPercentString(String percentString) {
        this.percentString = percentString;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getCalories() {
        return servingCalories;
    }

    public void setCalories(int servingCalories) {
        this.servingCalories = servingCalories;
    }

    public double getServings() {
        return servings;
    }

    public void setServings(double servings) {
        this.servings = servings;
    }

    public double getTotalProteins() {
        return totalProteins;
    }

    public void setTotalProteins(double totalProteins) {
        this.totalProteins = totalProteins;
    }

    public double getTotalCarbs() {
        return totalCarbs;
    }

    public void setTotalCarbs(double totalCarbs) {
        this.totalCarbs = totalCarbs;
    }

    public double getTotalFats() {
        return totalFats;
    }

    public void setTotalFats(double totalFats) {
        this.totalFats = totalFats;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public double getProCals() {
        return proCals;
    }

    public void setProCals(int proCals) {
        this.proCals = proCals;
    }

    public double getCarbCals() {
        return carbCals;
    }

    public void setCarbCals(int carbCals) {
        this.carbCals = carbCals;
    }

    public double getFatCals() {
        return fatCals;
    }

    public void setFatCals(int fatCals) {
        this.fatCals = fatCals;
    }

    public double getPerCarb() {
        return perCarb;
    }

    public void setPerCarb(double perCarb) {
        this.perCarb = perCarb;
    }

    public double getPerProt() {
        return perProt;
    }

    public void setPerProt(double perProt) {
        this.perProt = perProt;
    }

    public double getPerFat() {
        return perFat;
    }

    public void setPerFat(double perFat) {
        this.perFat = perFat;
    }

    public boolean isIs404020() {
        return is404020;
    }

    public void setIs404020(boolean is404020) {
        this.is404020 = is404020;
    }
}




