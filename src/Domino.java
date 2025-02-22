public class Domino {
    private int top;
    private int bottom;

    public Domino() {
        top = 0;
        bottom = 0;
    }

    public Domino(int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
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
        int otherSmallest = Math.min(top, bottom);
        int thisLargest = Math.max(top, bottom);
        int otherLargest = Math.max(top, bottom);
        if (thisSmallest < otherSmallest) {
            return -1;
        } else if (thisSmallest > otherSmallest) {
            return 1;
        } else if (thisSmallest == otherSmallest) {
            if (thisLargest < otherLargest) {
                return -1;
            } else if (thisLargest < otherLargest) {
                return 1;
            }
        }
        return 0;
    }

    public int compareToWeight(Domino other){
        int thisTotalDots = getTop() + getBottom();
        int otherTotalDots = other.getTop() + other.getBottom();
        if (thisTotalDots < otherTotalDots){
            return -1;
        }
        else if (thisTotalDots > otherTotalDots){
            return 1;
        }
        else {
            return 0;
        }
    }

    public boolean canConnect(Domino other){
        int thisTopDots = getTop();
        int thisBottomDots = getBottom();
        int otherTopDots = other.getTop();
        int otherBottomDots = other.getBottom();
        if (thisTopDots == otherTopDots || thisTopDots == otherBottomDots || thisBottomDots == otherTopDots || thisBottomDots == otherBottomDots){
            return true;
        }
        return false;
    }

}
