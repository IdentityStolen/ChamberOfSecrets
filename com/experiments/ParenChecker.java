/**
 * Checks if parenthesis are appropriate
 */
package com.experiments;

import java.util.*;

/**
 * @author SK030960
 *
 */
public class ParenChecker {

    private static final Character OPENING_CURLY_BRACE = '{';
    private static final Character CLOSING_CURLY_BRACE = '}';

    private static final Character OPENING_SQUARE_BRACE = '[';
    private static final Character CLOSING_SQUARE_BRACE = ']';

    private static final Character OPENING_BRACE = '(';
    private static final Character CLOSING_BRACE = ')';

    private static final Collection<Character> ALL_PARENTHESIS_CHARS = new HashSet<>();
    private static final Collection<Character> ALL_OPENING_PARENTHESIS_CHARS = new HashSet<>();
    private static final Collection<Character> ALL_CLOSING_PARENTHESIS_CHARS = new HashSet<>();

    private static final Map<Character, Parenthesis> closingBraceToParenthesisMap = new HashMap<>();

    private enum Parenthesis {

        CURLY(OPENING_CURLY_BRACE, CLOSING_CURLY_BRACE),
        SQUARE(OPENING_SQUARE_BRACE, CLOSING_SQUARE_BRACE),
        CIRCLE(OPENING_BRACE, CLOSING_BRACE);

        private final Character opening;
        private final Character closing;

        Parenthesis(Character opening, Character closing) {
            this.opening = opening;
            this.closing = closing;

            ALL_OPENING_PARENTHESIS_CHARS.add(opening);
            ALL_PARENTHESIS_CHARS.add(opening);

            ALL_CLOSING_PARENTHESIS_CHARS.add(closing);
            ALL_PARENTHESIS_CHARS.add(closing);

            closingBraceToParenthesisMap.put(closing, this);
        }

        public Character getOpening() {
            return opening;
        }

        public Character getClosing() {
            return closing;
        }
    }

    static boolean isOpeningBraceAvailableForCorrespondingClosingBrace(Parenthesis parenthesis, Stack<Character> stack, Character c) {
        if (parenthesis.getClosing().equals(c)) {
            if (!stack.isEmpty()) {
                Character c1 = stack.pop();
                if (c1 != parenthesis.getOpening()) return false;
            } else return false;
        }
        return false;
    }


    static boolean areParenthesisBalanced(String s) {
        char c1 = 'a';
        Stack<Character> stack = new Stack<>();    //Never compromise on type safety.

        char[] stringArray = s.toCharArray();
        for (Character c : stringArray) {
            if (isValidClosingParenthesisChar(c)) stack.push(c);
            else {
                Parenthesis parenthesis = closingBraceToParenthesisMap.get(c);
                if (parenthesis != null) {
                    return isOpeningBraceAvailableForCorrespondingClosingBrace(parenthesis, stack, c);
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValidClosingParenthesisChar(Character c) {
        return ALL_CLOSING_PARENTHESIS_CHARS.contains(c);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(areParenthesisBalanced("aa bb {[[]]} cc + dd [[[]]]"));
    }

}
