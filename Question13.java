/*
Q13. Create a custom exception that do not have any stack trace.
*/

package com.company;

class ExceptionExample{
    public static void main(String [] args) {
        try {
            throw new GenerateException("Custom Exception without Stack Trace", false);
        } catch (GenerateException e) {
            e.printStackTrace();
        }

        try {
            throw new GenerateException("Custom Exception with Stack Trace", true);
        } catch (GenerateException e) {
            e.printStackTrace();
        }
    }
}

class GenerateException extends Exception{
    public GenerateException(String msg , boolean printStacktrace){
        super(msg ,null,!printStacktrace,printStacktrace);
    }
}

