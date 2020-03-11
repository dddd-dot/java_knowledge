package com.java.test.algo.Josephus;


import lombok.extern.slf4j.Slf4j;

/**
 * 据说著名犹太历史学家 Josephus有过以下的故事：在罗马人占领乔塔帕特后，39 个犹太人与Josephus及他的朋友躲到一个洞中，39个犹太人决定宁愿死也不要被敌人抓到，于是决定了一个自杀方式，41个人排成一个圆圈，由第1个人开始报数，每报数到第3人该人就必须自杀，然后再由下一个重新报数，直到所有人都自杀身亡为止。然而Josephus 和他的朋友并不想遵从。首先从一个人开始，越过k-2个人（因为第一个人已经被越过），并杀掉第k个人。接着，再越过k-1个人，并杀掉第k个人。这个过程沿着圆圈一直进行，直到最终只剩下一个人留下，这个人就可以继续活着。问题是，给定了和，一开始要站在什么地方才能避免被处决？Josephus要他的朋友先假装遵从，他将朋友与自己安排在第16个与第31个位置，于是逃过了这场死亡游戏
 *
 * @author xbuding
 * @version 1.0
 * @since 2020/3/10
 */
@Slf4j
public class Test {

    /**
     * @param startIndex 第几个开始数
     * @param n          总人数
     * @param count      数几位数 出局一位
     */
    public static void gameStart(int startIndex, int n, int count) {
        // 1、建立链表
        Person head = new Person(0);
        Person temp = head;
        for (int i = 1; i <= n; i++) {
            Person person = new Person(i);
            temp.setNext(person);
            temp = person;
        }
        temp.setNext(head.getNext());
        Person startPerson;
        for (; ; ) {
            if (head.getNext().getIndex() == startIndex) {
                startPerson = head.getNext();
                break;
            } else {
                head = head.getNext();
            }
        }
        int round = 1;
        while (startPerson.getNext() != startPerson) {
            for (int i = 1; i < count - 1; i++) {
                startPerson = startPerson.getNext();
            }
            log.info("第 {} 轮，出局 {}", round, startPerson.getNext().getIndex());
            startPerson.setNext(startPerson.getNext().getNext());
            startPerson = startPerson.getNext();
            round++;
        }
        log.info("最后一轮 出局 {}", startPerson.getIndex());
    }

    public static void main(String[] args) {
        gameStart(1, 41, 3);
    }
}


class Person {
    /**
     * 号数
     */
    private int index;
    /**
     * 下一位
     */
    private Person next;

    public Person(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }
}