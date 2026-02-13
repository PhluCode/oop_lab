package com.library.lab02;

public class Member {
    private String memberID;
    private String memberName;
    private int borrowCount;
    private final int maxLimit = 3;


    public Member(String memberID, String memberName) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.borrowCount = 0;
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
}
