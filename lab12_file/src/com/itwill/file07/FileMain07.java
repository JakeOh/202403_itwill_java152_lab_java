package com.itwill.file07;

/*
 * IO Stream: 바이트 스트림(byte stream). 읽기/쓰기의 기본 단위는 byte 단위.
 *   모든 종류의 파일(txt, jpg, mp4, pptx, pdf, ...)에서 사용 가능.
 * InputStream
 * |__ FileInputStream, BufferedInputStream, ObjectInputStream, ...
 * OutputStream
 * |__ FileOutputStream, BufferedOutputStream, ObjectOutputStream, ...
 * 
 * Reader/Writer: 문자 스트림(character stream). 읽기/쓰기의 기본 단위는 "문자(character)".
 *   텍스트 파일(txt, csv, ...)에서만 사용.
 * Reader
 * |__ InputStreamReader, BufferedReader
 *     |__ FileReader
 * Writer
 * |__ OutputStreamWriter, BufferedWriter
 *     |__ FileWriter
 *     
 * 인코딩(encoding): 문자를 그 문자에 해당하는 코드(정수) 값으로 변환. (예) 'A' -> 65
 * 디코딩(decoding): 문자 코드(정수)를 그 코드에 해당하는 문자로 변환. (예) 65 -> 'A'
 * 운영체제(OS)의 기본 인코딩 방식:
 *   - Unix, Linux, MacOS: UTF-8
 *   - 한글 MS Windows: MS949(CP949, EUC-KR), 영문 MS Windows(CP1252), ...
 */

public class FileMain07 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
