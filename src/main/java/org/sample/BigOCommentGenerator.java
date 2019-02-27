package org.sample;

import java.util.Scanner;

public class BigOCommentGenerator {

    private static String[] bigOTypes = {"worst", "average", "best"};
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String title = "big o notation - ";

        StringBuilder stringBuilder = new StringBuilder();

        String sortingAlgoName = input.nextLine();
        title += sortingAlgoName;
        stringBuilder.append(title);
        stringBuilder.append("\n");
        System.out.println(stringBuilder.toString().length());

        for(int i = 0; i < bigOTypes.length; i++){
            System.out.print("enter big o for " + bigOTypes[i] + " case scenario...");
            String bigONotationType = input.nextLine();
            stringBuilder.append(bigOTypes[i] + " case: " + bigONotationType);
            if(i != bigOTypes.length - 1)
                stringBuilder.append("\n");
        }

        String finalComment = stringBuilder.toString();
        System.out.println(finalComment);
        System.out.println("length" + finalComment.length());


        System.out.println(addBorder(finalComment));

    }

    private static String addBorder(String originalText){
        int titleCount = 0;
        while(originalText.charAt(titleCount) != '\n'){
            titleCount++;
        }

        int titleLength = titleCount;

        String textWithBorder = originalText.substring(0, titleLength) + "\n";

        String captureTextWithBorder = textWithBorder;

        titleCount++;
        int prevLineEnd = titleCount;
        int lineCount = titleCount;

        for(int i = titleCount; i < originalText.length(); i++){
            if(originalText.charAt(i) == '\n' || i == originalText.length() - 1){

                String line = "";

                if(i == originalText.length() - 1){
                    line += originalText.substring(prevLineEnd, lineCount + 1);
                    line += genChars('-', (titleLength - ((lineCount + 1) - prevLineEnd)));
                }else{
                    line += originalText.substring(prevLineEnd, lineCount );
                    line += genChars('-', (titleLength - (lineCount - prevLineEnd)));
                }

//                line += " " + vertical;
                line += "\n";
                lineCount++;

                prevLineEnd = lineCount;
                textWithBorder += line;
            }else{
                lineCount++;
            }
        }

        textWithBorder += genChars('-', titleLength);

        return textWithBorder;
    }

    private static String genChars(char character, int length){
        String charSequence = "";
        System.out.println("space size is " + charSequence.length());
        for(int i = 0; i < length; i++)
            charSequence += character;
        return charSequence;
    }
}
