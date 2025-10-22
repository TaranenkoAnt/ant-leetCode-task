package ru.spb.taranenkoant.leetCode;


import ru.spb.taranenkoant.leetCode.additional.ListNode;

/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 22.10.2025
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode node5  = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
//        ListNode listNode = reverseList(node1);
        ListNode listNode = reverseListRecursive(node1);
        System.out.println(listNode);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode next = current.next;
        ListNode prev = null;
        while (next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        current.next = prev;
        return current;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        // Базовый случай: пустой список или список из одного элемента
        if (head == null || head.next == null) {
            return head;
        }

        // Рекурсивно разворачиваем хвост списка (всё, кроме головы)
        ListNode newHead = reverseListRecursive(head.next);

        // На этом этапе:
        // head всё ещё указывает на второй узел развернутого списка
        // Например, для [1,2,3,4]: head = 1, head.next = 2, newHead = 4
        // Список выглядит так: 1 -> 2 <- 3 <- 4

        // Разворачиваем указатель: теперь второй узел должен указывать на первый
        head.next.next = head;

        // Обрываем старую связь первого узла, чтобы не создавать цикл
        head.next = null;

        // Возвращаем новую голову, которая не меняется на всех уровнях рекурсии
        return newHead;
    }

}
