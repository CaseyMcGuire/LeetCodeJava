package main.com.leetcode.problems.problem0609;

import java.util.*;

public class Solution {
  public List<List<String>> findDuplicate(String[] paths) {
    List<List<File>> files = parsePaths(paths);
    Map<String, List<String>> contentToFullFileName = new HashMap<>();
    for (List<File> fileList : files) {
      for (File file : fileList) {
        List<String> filesWithContent = contentToFullFileName.getOrDefault(file.content, new ArrayList<>());
        filesWithContent.add(file.getFullPathName());
        contentToFullFileName.put(file.content, filesWithContent);
      }
    }

    List<List<String>> duplicateFilePaths = new ArrayList<>();
    for (Collection<String> filesWithSameContent : contentToFullFileName.values()) {
      if (filesWithSameContent.size() > 1) {
        duplicateFilePaths.add(new ArrayList<>(filesWithSameContent));
      }
    }
    return duplicateFilePaths;
  }

  private List<List<File>> parsePaths(String[] paths) {
    List<List<File>> files = new ArrayList<>();
    for (String path : paths) {
      files.add(parseFiles(path));
    }
    return files;
  }


  private List<File> parseFiles(String path) {
    StringBuilder directoryBuilder = new StringBuilder();
    int i = 0;
    for (; i < path.length() && path.charAt(i) != ' '; i++) {
      directoryBuilder.append(path.charAt(i));
    }
    List<File> files = new ArrayList<>();
    String directory = directoryBuilder.toString();
    i++;
    File currentFile = parseFile(path, directory, i);
    while (currentFile != null) {
      files.add(currentFile);
      i = i + currentFile.content.length() + currentFile.name.length() + 2; // for '(' and ')'
      currentFile = parseFile(path, directory, i);
    }
    return files;
  }

  private File parseFile(String path, String directory, int start) {
    if (start >= path.length()) {
      return null;
    }
    StringBuilder fileNameBuilder = new StringBuilder();
    int i = start;
    for (; i < path.length() && path.charAt(i) != '('; i++) {
      fileNameBuilder.append(path.charAt(i));
    }

    StringBuilder contentBuilder = new StringBuilder();
    for (; i < path.length() && path.charAt(i) != ')'; i++) {
      contentBuilder.append(path.charAt(i));
    }
    return new File(fileNameBuilder.toString(), contentBuilder.toString(), directory);
  }

  private static class File {
    private final String name;
    private final String content;
    private final String directory;

    File(String name, String content, String directory) {
      this.name = name;
      this.content = content;
      this.directory = directory;
    }

    private String getFullPathName() {
      return directory + "/" + name;
    }
  }

}
