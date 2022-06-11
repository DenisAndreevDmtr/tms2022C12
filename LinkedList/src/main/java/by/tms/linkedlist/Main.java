package by.tms.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.add("стул");
        list.add("стол");
        list.add("стол");
        list.remove(2);
        list.add("кровать");
        LinkList list2 = new LinkList();
        list2.add("диван");
        list2.add("шкаф");
        list.addAll(list2);
        list.set(1, "стол №2");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("первый элемент: " + list.getFirst());
        System.out.println("последний элемент: " + list.getLast());
        System.out.println("лист содержит диван " + list.contains("диван"));
        list.clear();
        System.out.println("длина листа после отчистки " + list.size());
    }
}