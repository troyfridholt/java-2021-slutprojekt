import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Account> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Account>();
    }

    public boolean addBranch(String branchName){
        if(findBranch(branchName) == null){
            this.branches.add(new Account(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialaAmount){
        Account branch = findBranch(branchName);
        if(branch != null){
            return branch.newCustomer(customerName,initialaAmount);
        }
        return false;
    }

    public boolean addCustomerTransactions(String branchName, String customerName, double amount){
        Account branch = findBranch(branchName);
        if(branch != null){
            return branch.addCustomerTransaction(customerName,amount);
        }
        return false;
    }

    private Account findBranch(String branchName){
        for(int i=0;i<this.branches.size();i++){
            Account checkedBranch = this.branches.get(i);
            if(checkedBranch.getName().equals(branchName)){
                return checkedBranch;
            }
        }
        return null;
    }
    public boolean listCustomers(String branchName, boolean showTransactions) {
        Account branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer Detaljer för systemet- " + branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer : " + branchCustomer.getName() + "[" + (i + 1) + "]");
                if (showTransactions) {
                    System.out.println("Transaktioner - ");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Volym = " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}