public class ComboListDriver {
    public static void main(String[] args) throws Exception {

        ComboList<Integer> combolist = new ComboList<Integer>(10);
        
        for (int i = 0; i < 100; i++) {
            combolist.add(i);
        }

        combolist.sneakPeek();
        System.out.println(combolist.size());

    }
} 