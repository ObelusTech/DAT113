package TT;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class InputFilter extends DocumentFilter {

    private JTextField inputElement;

    public InputFilter(JTextField inputElement) {
        this.inputElement = inputElement;
    }

    private boolean test(String text) {
        try {
            int val = Integer.parseInt(text);
            if(val >= 1 && val <= 9) {
                return true;
            }
        } catch (NumberFormatException e) {
            if(text.length() == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
                        AttributeSet attrs) throws BadLocationException {

        String oldText = fb.getDocument().getText(0, fb.getDocument().getLength());
        if(test(text)) {
            String newstring = (text.length() > 0) ? text.substring(text.length() - 1) : text;
            fb.replace(
                    0,
                    oldText.length(),
                    newstring,
                    attrs
            );

            inputElement.postActionEvent();

        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
    }
}