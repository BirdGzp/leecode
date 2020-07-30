package jvm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SplitFile
{
	public static void main(String args[])
	{

		String file = "/data/urs/call_bk_ssn_20200609_";
		for (int i = 0; i < 20; i++) {
			String fileName = file + String.format("%02d", i);
			int startPoint = 0;
			if(fileName.endsWith("00"))
			{
				startPoint = 59400000;
			}
			else if(fileName.endsWith("13") || fileName.endsWith("15"))
			{
				startPoint = 56100000;
			}
			else
			{
				startPoint = 57900000;
			}
			System.out.println(fileName + "" + startPoint);
		}
//		splitFileByLine("D:\\data\\urs.sql", "D:\\data\\t", 8000000);
	}

	public static int splitFileByLine(String sourceFilePath, String targetDirectoryPath, int rows)
	{
		String sourceFileName = sourceFilePath
				.substring(sourceFilePath.lastIndexOf(File.separator) + 1, sourceFilePath.lastIndexOf("."));//源文件名
		String splitFileName = targetDirectoryPath + File.separator + sourceFileName + "-%s.txt";//切割后的文件名
		File targetDirectory = new File(targetDirectoryPath);
		if (!targetDirectory.exists())
		{
			targetDirectory.mkdirs();
		}

		PrintWriter pw = null;//字符输出流
		String tempLine;
		int lineNum = 0;//本次行数累计 , 达到rows开辟新文件
		int splitFileIndex = 1;//当前文件索引

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFilePath))))
		{
			pw = new PrintWriter(String.format(splitFileName, splitFileIndex));
			while ((tempLine = br.readLine()) != null)
			{
				if (lineNum > 0 && lineNum % rows == 0)
				{//需要换新文件
					pw.flush();
					pw.close();
					pw = new PrintWriter(String.format(splitFileName, ++splitFileIndex));
				}
				pw.write(tempLine + "\n");
				lineNum++;
			}
			return splitFileIndex;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return -1;
		}
		finally
		{
			if (null != pw)
			{
				pw.flush();
				pw.close();
			}
		}

	}
}