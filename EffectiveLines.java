package com.qunar.My_homework;

import java.io.*;

/**
 * Created by GuoChongyuan on 2017/1/7.
 */
public class EffectiveLines {
    /**
     * һ��ͳ��һ��Java�ļ�����Ч����������ҵ������EffectiveLines��
     * 1����Ч����������
     * 2�������Ǵ�����ж���ע�͵����
     */
    public static void main(String[] args) {
        String FilePath = "E:\\my_maven_test\\Guava_Test\\src\\main\\java\\com\\qunar\\My_homework\\EffectiveLines.java";
        int line = 0;
        try {
            line = getSimpleCommentLines(FilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(FilePath + "�ļ����д���" + line + "��");
    }

    //����������ע�͵����
    public static int getSimpleCommentLines(String FilePath) throws IOException {

        File file = new File(FilePath);
        int line = 0;
        if (file.isFile() && file.getName().endsWith(".java")) {//Ϊjava �ļ�ʱ

            //�жϱ����ʽ��
            String fileCode = getCode(file);
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), fileCode));
            } catch (UnsupportedEncodingException e) {
                System.out.print("UnsupportedEncodingException");
            }
            String s = null;
            while ((s = br.readLine()) != null) {
                s = s.replaceAll("\\s", "");// \\s��ʾ �ո�,�س�,���еȿհ׷�,
                // ���հ׷��滻Ϊ���ַ�""

                if ("".equals(s)
                        || s.startsWith("//")
                        || s.startsWith("/*")
                        || s.startsWith("/**")
                        || s.startsWith("*")
                        ) {//���˵�ע��
                } else {
                    line++;
                }
            }
            br.close();//�رն�����
        } else if (file.isDirectory()) {// ��file ΪĿ¼ʱ���ݹ����
            line = -1;//�����������ļ��У�����-1
        }
        return line;
    }

    //��������ע�͵���չ����
    public static int getMultiLineCommentLines(String FilePath) throws IOException {

        File file = new File(FilePath);
        int line = 0;
        if (file.isFile() && file.getName().endsWith(".java")) {//Ϊjava �ļ�ʱ

            //�жϱ����ʽ��
            String fileCode = getCode(file);
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), fileCode));
            } catch (UnsupportedEncodingException e) {
                System.out.print("UnsupportedEncodingException");
            }
            String s = null;
            while ((s = br.readLine()) != null) {
                s = s.replaceAll("\\s", "");// \\s��ʾ �ո�,�س�,���еȿհ׷�,
                // ���հ׷��滻Ϊ���ַ�""

                if ("".equals(s)
                        || s.startsWith("//")) {//���˵�ע��
                }else if (s.startsWith("/*")
                        ||s.startsWith("/**")){
                    while((s = br.readLine()) != null && !(s.endsWith("*/"))){

                    }
                } else {
                    line++;
                }
            }
            br.close();//�رն�����
        } else if (file.isDirectory()) {// ��file ΪĿ¼ʱ���ݹ����
            line = -1;//�����������ļ��У�����-1
        }
        return line;
    }

    private static String getCode (File file) {
        //��Ϊ������Java�ļ��ı����ʽΪgbk����utf-8���룬������������ֱ�������ж�
        //��Ϊ��ϸ�ı����жϿ���ʹ�ÿ�Դ��Ŀcpdetector����ַ�ǣ�http://cpdetector.sourceforge.net/
        InputStream in= null;
        String FileCode = null;
        try {
            in = new FileInputStream(file);
            byte[] b = new byte[3];
            try {
                in.read(b);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (b[0] == -17 && b[1] == -69 && b[2] == -65)//�ж��Ƿ�Ϊutf-8����
                FileCode =  "utf-8";
            else
                FileCode =  "gbk";
        } catch (FileNotFoundException e) {
            System.out.print("FileNotFound");
        }
         return FileCode;
    }
}


