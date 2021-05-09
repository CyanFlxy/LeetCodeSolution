package com.cyanflxy.leetcode._7;

import com.cyanflxy.leetcode.help.Utils;

import java.util.*;

/**
 * @author cyanflxy
 * @since 2021.05.09
 */
public class _721 {

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Utils.toList("David", "David0@m.co", "David1@m.co"));
        list.add(Utils.toList("David", "David3@m.co", "David4@m.co"));
        list.add(Utils.toList("David", "David4@m.co", "David5@m.co"));
        list.add(Utils.toList("David", "David2@m.co", "David3@m.co"));
        list.add(Utils.toList("David", "David1@m.co", "David2@m.co"));

        List<List<String>> result = new _721().accountsMerge(list);
        System.out.println(result);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Set<Account> accountSet = new HashSet<>();
        Map<String, Account> accountEmailMap = new HashMap<>();

        for (List<String> account : accounts) {
            Set<Account> sameAccount = new HashSet<>();
            List<String> emails = account.subList(1, account.size());
            Set<String> sameAccountEmails = new HashSet<>();

            for (String email : emails) {
                Account a = accountEmailMap.get(email);
                if (a != null) {
                    sameAccount.add(a);
                    sameAccountEmails.addAll(a.emails);
                }
            }

            accountSet.removeAll(sameAccount);
            for (String str : sameAccountEmails) {
                accountEmailMap.remove(str);
            }
            sameAccountEmails.addAll(emails);
            Account merge = mergeAccount(account.get(0), emails, sameAccount);
            accountSet.add(merge);

            for (String email : sameAccountEmails) {
                accountEmailMap.put(email, merge);
            }

        }

        List<List<String>> result = new ArrayList<>();
        for (Account account : accountSet) {
            result.add(account.toList());
        }
        return result;
    }

    private Account mergeAccount(String name, List<String> emails, Set<Account> sameAccount) {
        if (sameAccount.size() == 0) {
            Account result = new Account();
            result.name = name;
            result.emails.addAll(emails);
            return result;
        }

        Account merged = null;
        for (Account account : sameAccount) {
            if (merged == null) {
                merged = account;
            } else {
                merged.emails.addAll(account.emails);
            }
        }
        merged.emails.addAll(emails);
        return merged;
    }

    static class Account {
        String name;
        Set<String> emails = new TreeSet<>();

        List<String> toList() {
            List<String> list = new ArrayList<>();
            list.add(name);
            list.addAll(emails);
            return list;
        }
    }
}
