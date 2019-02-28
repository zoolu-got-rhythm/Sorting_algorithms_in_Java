package org.sample;

import java.util.Scanner;

public class BigOCommentGenerator {

    private static String[] bigOTypes = {"worst", "average", "best"};
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("please type in sorting algorithm name...");

        String title = "time complexity - ";
        StringBuilder stringBuilder = new StringBuilder();
        String sortingAlgoName = input.nextLine();
        title += sortingAlgoName;
        stringBuilder.append(title);
        stringBuilder.append("\n");

        for(int i = 0; i < bigOTypes.length; i++){
            System.out.print("enter big o for " + bigOTypes[i] + " case scenario...");
            String bigONotationType = input.nextLine();
            stringBuilder.append(bigOTypes[i] + " case: " + bigONotationType);
            if(i != bigOTypes.length - 1)
                stringBuilder.append("\n");
        }

        String finalComment = stringBuilder.toString();

        System.out.println(addBorder(finalComment));

    }

    private static String addBorder(String originalText){
        int titleCount = 0;
        while(originalText.charAt(titleCount) != '\n'){
            titleCount++;
        }

        int titleLength = titleCount;

        String textWithBorder = " - " + originalText.substring(0, titleLength).toUpperCase() + " - " + "\n";

        String captureTextWithBorder = textWithBorder;

        titleCount++;
        int prevLineEnd = titleCount;
        int lineCount = titleCount;

        for(int i = titleCount; i < originalText.length(); i++){
            if(originalText.charAt(i) == '\n' || i == originalText.length() - 1){

                String line = "| ";

                // if else to handle case where no newline char is present on last line of original text,
                // note: could refactor loop to be i <= originalText.length() instead, may fix issue
                if(i == originalText.length() - 1){
                    line += originalText.substring(prevLineEnd, lineCount + 1);
                    line += genChars(' ', (captureTextWithBorder.length() - ((lineCount + 4 + 1) - prevLineEnd)));
                }else{
                    line += originalText.substring(prevLineEnd, lineCount );
                    line += genChars(' ', (captureTextWithBorder.length() - ((lineCount + 4) - prevLineEnd)));
                }

//                line += " " + vertical;
                line += "|";
                line += "\n";
                lineCount++;

                prevLineEnd = lineCount;
                textWithBorder += line;
            }else{
                lineCount++;
            }
        }

        // length -1 to account for newline character in captureTextWithBorder string
        // + 2 to length to account for 2 space characters
        textWithBorder += " " + genChars('-', captureTextWithBorder.length() - (1 + 2)) + " ";

        return textWithBorder;
    }

    private static String genChars(char character, int length){
        String charSequence = "";
        System.out.println("space size is " + charSequence.length());
        for(int i = 0; i < length; i++){
            charSequence += character;
        }
        return charSequence;
    }
}
