package com.farm.game.Input;

import com.badlogic.gdx.InputProcessor;
import java.util.HashMap;
import java.util.Map;
import com.badlogic.gdx.Input.Keys;

public class Input implements InputProcessor {

    private static int _key = -1;
    private static int _oldKey = -1;

    @Override
    public boolean keyDown(int keycode) {
        _key = keycode;
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        _oldKey = _key;
        _key = -1;
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    public static enum Key {
        ENTER,
        BACKSPACE,
        TAB,
        CLEAR,
        SHIFT,
        CONTROL,
        ALT,
        PAUSE,
        CAPSLOCK,
        ESCAPE,
        SPACE,
        PAGEUP,
        PAGEDOWN,
        END,
        HOME,
        LEFT,
        UP,
        RIGHT,
        DOWN,
        COMMA,
        MINUS,
        PERIOD,
        SLASH,
        NUM_0,
        NUM_1,
        NUM_2,
        NUM_3,
        NUM_4,
        NUM_5,
        NUM_6,
        NUM_7,
        NUM_8,
        NUM_9,
        SEMICOLON,
        EQUALS,
        A,
        B,
        C,
        D,
        E,
        F,
        G,
        H,
        I,
        J,
        K,
        L,
        M,
        N,
        O,
        P,
        Q,
        R,
        S,
        T,
        U,
        V,
        W,
        X,
        Y,
        Z,
        NUMPAD_0,
        NUMPAD_1,
        NUMPAD_2,
        NUMPAD_3,
        NUMPAD_4,
        NUMPAD_5,
        NUMPAD_6,
        NUMPAD_7,
        NUMPAD_8,
        NUMPAD_9,
        MULTIPLY,
        ADD,
        SUBSTRACT,
        DIVIDE,
        DELETE,
        NUMLOCK,
        F1,
        F2,
        F3,
        F4,
        F5,
        F6,
        F7,
        F8,
        F9,
        F10,
        F11,
        F12,
        F13,
        F14,
        F15,
        F16,
        F17,
        F18,
        F19,
        F20,
        F21,
        F22,
        F23,
        F24,
        PRINTSCREEN,
        INSERT,
        KEYPAD_UP,
        KEYPAD_DOWN,
        KEYPAD_LEFT,
        KEYPAD_RIGHT,
        NONE
    }

    private static final HashMap<Input.Key, Integer> _inputMap = new HashMap<Key, Integer>() {{
        put(Key.ENTER, Keys.ENTER);
        put(Key.BACKSPACE, Keys.BACKSPACE);
        put(Key.TAB, Keys.TAB);
        put(Key.CLEAR, Keys.CLEAR);
        put(Key.SHIFT, Keys.SHIFT_LEFT);
        put(Key.CONTROL, Keys.CONTROL_LEFT);
        put(Key.ALT, Keys.ALT_LEFT);
        put(Key.PAUSE, Keys.PAUSE);
        put(Key.CAPSLOCK, Keys.CAPS_LOCK);
        put(Key.ESCAPE, Keys.ESCAPE);
        put(Key.SPACE, Keys.SPACE);
        put(Key.PAGEUP, Keys.PAGE_UP);
        put(Key.PAGEDOWN, Keys.PAGE_DOWN);
        put(Key.END, Keys.END);
        put(Key.HOME, Keys.HOME);
        put(Key.LEFT, Keys.LEFT);
        put(Key.UP, Keys.UP);
        put(Key.RIGHT, Keys.RIGHT);
        put(Key.DOWN, Keys.DOWN);
        put(Key.COMMA, Keys.COMMA);
        put(Key.MINUS, Keys.MINUS);
        put(Key.PERIOD, Keys.PERIOD);
        put(Key.SLASH, Keys.SLASH);
        put(Key.NUM_0, Keys.NUM_0);
        put(Key.NUM_1, Keys.NUM_1);
        put(Key.NUM_2, Keys.NUM_2);
        put(Key.NUM_3, Keys.NUM_3);
        put(Key.NUM_4, Keys.NUM_4);
        put(Key.NUM_5, Keys.NUM_5);
        put(Key.NUM_6, Keys.NUM_6);
        put(Key.NUM_7, Keys.NUM_7);
        put(Key.NUM_8, Keys.NUM_8);
        put(Key.NUM_9, Keys.NUM_9);
        put(Key.SEMICOLON, Keys.SEMICOLON);
        put(Key.EQUALS, Keys.EQUALS);
        put(Key.A, Keys.A);
        put(Key.B, Keys.B);
        put(Key.C, Keys.C);
        put(Key.D, Keys.D);
        put(Key.E, Keys.E);
        put(Key.F, Keys.F);
        put(Key.G, Keys.G);
        put(Key.H, Keys.H);
        put(Key.I, Keys.I);
        put(Key.J, Keys.J);
        put(Key.K, Keys.K);
        put(Key.L, Keys.L);
        put(Key.M, Keys.M);
        put(Key.N, Keys.N);
        put(Key.O, Keys.O);
        put(Key.P, Keys.P);
        put(Key.Q, Keys.Q);
        put(Key.R, Keys.R);
        put(Key.S, Keys.S);
        put(Key.T, Keys.T);
        put(Key.U, Keys.U);
        put(Key.V, Keys.V);
        put(Key.W, Keys.W);
        put(Key.X, Keys.X);
        put(Key.Y, Keys.Y);
        put(Key.Z, Keys.Z);
        put(Key.NUMPAD_0, Keys.NUMPAD_0);
        put(Key.NUMPAD_1, Keys.NUMPAD_1);
        put(Key.NUMPAD_2, Keys.NUMPAD_2);
        put(Key.NUMPAD_3, Keys.NUMPAD_3);
        put(Key.NUMPAD_4, Keys.NUMPAD_4);
        put(Key.NUMPAD_5, Keys.NUMPAD_5);
        put(Key.NUMPAD_6, Keys.NUMPAD_6);
        put(Key.NUMPAD_7, Keys.NUMPAD_7);
        put(Key.NUMPAD_8, Keys.NUMPAD_8);
        put(Key.NUMPAD_9, Keys.NUMPAD_9);
        put(Key.MULTIPLY, Keys.STAR);
        put(Key.ADD, Keys.PLUS);
        put(Key.SUBSTRACT, Keys.MINUS);
        put(Key.DIVIDE, Keys.SLASH);
        put(Key.DELETE, Keys.DEL);
        put(Key.NUMLOCK, Keys.NUM_LOCK);
        put(Key.F1, Keys.F1);
        put(Key.F2, Keys.F2);
        put(Key.F3, Keys.F3);
        put(Key.F4, Keys.F4);
        put(Key.F5, Keys.F5);
        put(Key.F6, Keys.F6);
        put(Key.F7, Keys.F7);
        put(Key.F8, Keys.F8);
        put(Key.F9, Keys.F9);
        put(Key.F10, Keys.F10);
        put(Key.F11, Keys.F11);
        put(Key.F12, Keys.F12);
        put(Key.F13, Keys.F13);
        put(Key.F14, Keys.F14);
        put(Key.F15, Keys.F15);
        put(Key.F16, Keys.F16);
        put(Key.F17, Keys.F17);
        put(Key.F18, Keys.F18);
        put(Key.F19, Keys.F19);
        put(Key.F20, Keys.F20);
        put(Key.F21, Keys.F21);
        put(Key.F22, Keys.F22);
        put(Key.F23, Keys.F23);
        put(Key.F24, Keys.F24);
        put(Key.PRINTSCREEN, Keys.PRINT_SCREEN);
        put(Key.INSERT, Keys.INSERT);
        put(Key.KEYPAD_UP, Keys.DPAD_UP);
        put(Key.KEYPAD_DOWN, Keys.DPAD_DOWN);
        put(Key.KEYPAD_LEFT, Keys.DPAD_LEFT);
        put(Key.KEYPAD_RIGHT, Keys.DPAD_RIGHT);
        put(Key.NONE, -1);
    }};

    public static Key getKeyPressed() {
        for (Map.Entry<Key, Integer> entry : _inputMap.entrySet()) {
            if (entry.getValue() == _key)
                return entry.getKey();
        }
        return null;
    }

    public static boolean isKeyPressed(Key k) {
        for (Map.Entry<Key, Integer> entry : _inputMap.entrySet()) {
            if (entry.getValue() == _key) {
                return entry.getKey() == k;
            }
        }
        return false;
    }

    public static boolean isKeyReleased(Key k) {
        for (Map.Entry<Key, Integer> entry : _inputMap.entrySet()) {
            if (_oldKey == entry.getValue()) {
                if (entry.getKey() == k && _key == -1) {
                    _key = -2;
                    _oldKey = -1;
                    return true;
                }
            }
        }
        return false;
    }
}
