package main.com.leetcode.problems.problem0721;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, List<Account>> emailToAccounts = new HashMap<>();
    for (List<String> account : accounts) {
      Account curAccount = new Account(account.get(0), account.subList(1, account.size()));
      for (String email : curAccount.emails) {
        List<Account> accountsForEmail = emailToAccounts.getOrDefault(email, new ArrayList<>());
        accountsForEmail.add(curAccount);
        emailToAccounts.put(email, accountsForEmail);
      }
    }
    List<Account> mergedAccounts = new ArrayList<>();
    Set<String> visitedEmails = new HashSet<>();
    for (Map.Entry<String, List<Account>> entry : emailToAccounts.entrySet()) {
      if (visitedEmails.contains(entry.getKey())) {
        continue;
      }
      Account mergedAccount = mergeAccounts(entry.getValue().get(0), emailToAccounts, visitedEmails);
      mergedAccounts.add(mergedAccount);
    }
    return mergedAccounts.stream().map(Account::toList).collect(Collectors.toList());
  }

  private Account mergeAccounts(Account account, Map<String, List<Account>> emailToAccount, Set<String> visited) {
    for (String email : new ArrayList<>(account.emails)) {
      mergeAccounts(email, account, emailToAccount, visited);
    }
    return account;
  }

  private void mergeAccounts(String email, Account account, Map<String, List<Account>> emailToAccount, Set<String> visited) {
    visited.add(email);
    for (Account otherAccount : emailToAccount.get(email)) {
      if (otherAccount == account) {
        continue;
      }
      for (String otherEmail : otherAccount.emails) {
        if (visited.contains(otherEmail)) {
          continue;
        }
        account.merge(otherAccount);
        mergeAccounts(otherEmail, account, emailToAccount, visited);
      }
    }
  }



  private static class Account {
    private final String name;
    private final Set<String> emails;

    Account(String name, List<String> emails) {
      this.name = name;
      this.emails = new HashSet<>(emails);
    }

    void merge(Account other) {
      this.emails.addAll(other.emails);
    }

    List<String> toList() {
      List<String> list = new ArrayList<>();
      list.add(name);
      list.addAll(new TreeSet<>(emails));
      return list;
    }
  }
}
