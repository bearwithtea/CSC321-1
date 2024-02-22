public class ComboListDriver {
    public static void main(String[] args) throws Exception {

        ComboList<Integer> combolist = new ComboList<Integer>(100);
        
        for (int i = 0; i < 100; i++) {
            combolist.add(i);
        }

        for (int i = 0; i < combolist.size(); i++) {
            combolist.get(i);
        }

        combolist.sneakPeek();
        System.out.println(combolist.size());
        System.out.println(combolist.get(53));
        combolist.add(39, 1000);
        combolist.add(40, 45);
        combolist.add(99, 44);
        combolist.add(95, 431123984);
        combolist.sneakPeek();
        System.out.println(combolist.toList());
        System.out.println(combolist.toString());

    }
}