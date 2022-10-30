package HW2;
import java.lang.StringBuilder;
import java.util.Stack;

// Task 1 and 2

interface OnChangeListener {
    void onChange(MyStringBuilder myStringBuilder);
}

class MyStringBuilderListener implements OnChangeListener {
    @Override
    public void onChange(MyStringBuilder myStringBuilder) {
        // do something
    }
}

public class MyStringBuilder {
    private final StringBuilder strBuilder;
    private final Stack<Action> actionStack = new Stack<>();
    private OnChangeListener listener;

    public MyStringBuilder() {
        this.strBuilder = new StringBuilder();
    }

    private interface Action {
        void undo();
    }

    public void setOnChangeListener(OnChangeListener listener) {
        this.listener = listener;
    }

    private class DeleteAction implements Action {
        private final int size;

        public DeleteAction(int size) {
            this.size = size;
        }

        public void undo() {
            strBuilder.delete(strBuilder.length() - size, strBuilder.length());
        }
    }

    public MyStringBuilder reverse() {
        strBuilder.reverse();
        Action newAction = new Action() {
            @Override
            public void undo() {
                strBuilder.reverse();
            }
        };
        actionStack.add(newAction);
        notifyListener();
        return this;
    }

    public MyStringBuilder append(String string) {
        strBuilder.append(string);
        Action newAction = new Action() {
            @Override
            public void undo() {
                strBuilder.delete(
                        strBuilder.length() - string.length() -1,
                        strBuilder.length());
            }
        };
        actionStack.add(newAction);
        notifyListener();
        return this;
    }

    public MyStringBuilder delete(int start, int end) {
        String deleted = strBuilder.substring(start, end);
        strBuilder.delete(start, end);
        actionStack.add(() -> strBuilder.insert(start, deleted));
        notifyListener();
        return this;
    }

    public void undo() {
        if(!actionStack.isEmpty()){
            actionStack.pop().undo();
        }
        notifyListener();
    }

    private void notifyListener() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    public String toString() {
        return strBuilder.toString();
    }

}

