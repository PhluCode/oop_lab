package com.library.lab05;

public class Member {
    private String memberID;
    private String memberName;
    private int borrowCount;
    private final int maxLimit = 3;
    private MembershipStrategy strategy;


    public Member(String memberID, String memberName, MembershipStrategy strategy) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.borrowCount = 0;
        this.strategy = strategy;
    }

    public boolean canBorrow() {
        if (borrowCount > maxLimit) {
            System.out.println(" Member " + memberName + "has reached the borrow limit (" + maxLimit + ").");
            System.out.println(" Borrow request denied for member " + memberName);
            return false;
        }
        return true;
    }

    public void incrementBorrow() {
        this.borrowCount++;
    }

    public void decrementBorrow() {
        if (borrowCount > 0) this.borrowCount--;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }

    public void setMembershipStrategy(MembershipStrategy strategy) {
        this.strategy = strategy;
        System.out.println(" 🆙 Membership updated to: " + strategy.getMembershipType());
    }

    public void displayMemberInfo() {
        System.out.println("\n" + "-".repeat(40));
        System.out.println(" 👤 MEMBER INFORMATION");
        System.out.println("-".repeat(40));
        System.out.println(" ID: " + memberID);
        System.out.println(" Name: " + memberName);
        System.out.println(" Membership Type: " + strategy.getMembershipType());
        System.out.println(" Borrowing Status: " + borrowCount + " / " + strategy.getBorrowLimit() + " items");
        System.out.println(" Loan Period: " + strategy.getLoanPeriodDays() + " days");

        double exampleFee = 200.0;
        double discountedFee = strategy.applyLateFeeDiscount(exampleFee);
        System.out.println(" Late Fee Discount: " + (int)((1 - (discountedFee/exampleFee)) * 100) + "%");
        System.out.println("-".repeat(40));
    }

    public double calculateLateFee(double baseFee) {
        double finalFee = strategy.applyLateFeeDiscount(baseFee);

        System.out.println("Applying discount for " + strategy.getMembershipType() + "...");
        System.out.println("→ Base fee " + (int)baseFee + " → Final fee " + (int)finalFee);

        return finalFee;
    }

    public MembershipStrategy getStrategy() {
        return strategy;
    }
}
