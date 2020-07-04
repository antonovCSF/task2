public class Main {
    public static void main(String[] args) {
        String[] strings = "2 4 6 4 2 4".split(" ");
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < strings.length; i++) {
            list.add(Integer.parseInt(strings[i]));
        }
        list.removeEven();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
