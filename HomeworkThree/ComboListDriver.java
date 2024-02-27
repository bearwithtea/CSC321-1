public class ComboListDriver {
    public static void main(String[] args) throws Exception {

        ComboList<Integer> combolist = new ComboList<Integer>(10);
        
        for (int i = 0; i <= 97; i++) {
            combolist.add(i);
        }

        for (int i = 0; i < combolist.size(); i++) {
            combolist.get(i);
        }

        System.out.println("");
        System.out.println(combolist.size());
        System.out.println(combolist.get(53));
        combolist.add(39, 111);
        combolist.add(41, 222);
        combolist.add(94, 333);
        combolist.add(99, 444);
        combolist.sneakPeek();
        combolist.toList();
        combolist.toString();

    }
}