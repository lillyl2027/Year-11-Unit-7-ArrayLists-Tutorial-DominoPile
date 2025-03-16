public class Domino {
    private int top;
    private int bottom;

    public Domino() {
        top = 0;
        bottom = 0;
    }

    public Domino(int top, int bottom) {
        top = this.top;
        bottom = this.bottom;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public String toString() {
        return top + "/" + bottom;
    }

    public void flip() {
        int newTop = bottom;
        int newBottom = top;
    }

    public void settle() {
        if (bottom < top) {
            flip();
        }
    }

    public int compareTo(Domino other) {
        int thisSmallest = Math.min(top, bottom);
        int thisLargest = Math.max(top, bottom);
        int otherSmallest = Math.min(other.getTop(), other.getBottom());
        int otherLargest = Math.max(other.getTop(), other.getBottom());
        if (thisSmallest < otherSmallest) {
            return -1;
        } else if (thisSmallest > otherSmallest) {
            return 1;
        } else if (thisSmallest == otherSmallest) {
            if (thisLargest < otherLargest) {
                return -1;
            } else if (thisLargest > otherLargest) {
                return 1;
            }
        }
        return 0;
    }

    public int compareToWeight(Domino other) {
        int otherTotal = other.getTop() + other.getBottom();
        if (top < otherTotal || bottom < otherTotal) {
            return -1;
        } else if (top > otherTotal || bottom > otherTotal) {
            return 1;
        } else {
            return 0;
        }
    }


    public boolean canConnect(Domino other) {
        if (top == other.getTop()) {
            return true;
        } else if (top == other.getBottom()) {
            return true;
        } else if (bottom == other.getTop()) {
            return true;
        } else if (bottom == other.getBottom()) {
            return true;
        }
        return false;
    }
}