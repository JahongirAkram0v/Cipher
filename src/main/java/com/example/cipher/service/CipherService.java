package com.example.cipher.service;

import org.springframework.stereotype.Service;

@Service
public class CipherService {

    private final char[][] alphabet = new char[][]{
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', '5'},
            {'n', 'm', 'l', 'k', 'j', 'i', 'h', '6'},
            {'o', 'p', 'q', 'r', 's', 't', 'u', '7'},// 2 1
            {'B', 'A', 'z', 'y', 'x', 'w', 'v', '8'},
            {'C', 'D', 'E', 'F', 'G', 'H', 'I', '9'},
            {'P', 'O', 'N', 'M', 'L', 'K', 'J', '0'},
            {'Q', 'R', 'S', 'T', 'U', 'V', 'W', '_'},// 6 2
            {'4', '3', '2', '1', 'Z', 'Y', 'X', '~'}
    };

    private int[] findIndex(char a) {
        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (alphabet[i][j] == a) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public String makeCode(String text) {
        StringBuilder newText = new StringBuilder();
        for (char a : text.toCharArray()) {
            int[] temp = findIndex(a);
            newText.append(temp == null ? a : alphabet[alphabet.length - 1 - temp[1]][temp[0]]);
        }
        return newText.toString();
    }

    public String makeDecode(String text) {
        StringBuilder newText = new StringBuilder();
        for (char a : text.toCharArray()) {
            int[] temp = findIndex(a);
            newText.append(temp == null ? a : alphabet[temp[1]][alphabet.length -  - temp[0]]);
        }
        return newText.toString();
    }
}
