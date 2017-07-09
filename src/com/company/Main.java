package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static class Card {
        private String fullExpression;
        private int num;

        public void setFullExpression(String fullExpression) {
            this.fullExpression = fullExpression;
        }

        public String getFullExpression() {
            return fullExpression;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            // 入力される数
            int n = Integer.parseInt(bufferedReader.readLine());

            String[] fullExpressions = bufferedReader.readLine().split(" ");
            int[] numbers = new int[fullExpressions.length];
            Card[] cards = new Card[fullExpressions.length];

            int i = 0;
            for (String expression : fullExpressions) {
                numbers[i] = Integer.parseInt(expression.substring(1));
                i++;
            }

            for(int j = 0; j < fullExpressions.length; j++) {
                Card card = new Card();
                card.setFullExpression(fullExpressions[j]);
                card.setNum(numbers[j]);
                cards[j] = card;
            }

            selectionSort(cards, bubbleSort(cards));


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static Card[] bubbleSort(Card[] cards) {
        // 整列済み
        for (int i = 0; i < cards.length - 1; i++) {
            for (int j = cards.length - 1; j > i; j--) {
                if (cards[j].getNum() < cards[j - 1].getNum()) {
                    Card temp = cards[j];
                    cards[j] = cards[j - 1];
                    cards[j - 1] = temp;
                }
            }
        }
        for (int k = 0; k < cards.length; k++) {
            if (k == cards.length - 1) {
                System.out.println(cards[k].getFullExpression());
                System.out.println("Stable");
            } else {
                System.out.print(cards[k].getFullExpression() + " ");
            }
        }

        return cards;
    }

    private static void selectionSort(Card[] cards, Card[] bubbleSortedCards) {
        for (int i = 0; i < cards.length - 1; i++) {
            int min = i;
            for (int j = i; j < cards.length; j++) {
                if (cards[j].getNum() < cards[min].getNum()) {
                    min = j;
                }
            }
            if (min != i) {
                Card tmp = cards[i];
                cards[i] = cards[min];
                cards[min] = tmp;
            }
        }

        for (int k = 0; k < cards.length; k++) {
            if (k == cards.length - 1) {
                System.out.println(cards[k].getFullExpression());
                if (Arrays.equals(cards, bubbleSortedCards)) {
                    System.out.println("Stable");
                } else{
                    System.out.println("Not stable");
                }
            } else {
                System.out.print(cards[k].getFullExpression() + " ");
            }
        }
    }

}
