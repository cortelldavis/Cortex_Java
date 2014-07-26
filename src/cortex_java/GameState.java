/*
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package cortex_java;

/**
 *
 * @author Cortell Davis <cortelldavis@gmail.com>
 */
public class GameState {

    private State state;

    public final int START = 0;
    public final int PAUSE = 1;
    public final int EXIT = 2;
    public final int RESUME = 3;

    public State getState() {
        return state;
    }

    public void setState(int state) {

        switch (state) {
            case START:
                this.state = State.start;
                break;
            case PAUSE:
                this.state = State.pause;
                break;
            case EXIT:
                this.state = State.exit;
                break;
            case RESUME:
                this.state = State.resume;
                break;
        }

    }

    public boolean isStarting() {

        if (state == State.start) {
            return true;
        }
        return false;
    }

    public boolean isPausing() {

        if (state == State.pause) {
            return true;
        }
        return false;
    }

    public boolean isExiting() {

        if (state == State.exit) {
            return true;
        }
        return false;
    }

    public boolean isResuming() {

        if (state == State.resume) {
            return true;
        }
        return false;
    }

    public void onStart() {
        setState(START);
    }

    public void onPause() {

        setState(PAUSE);
    }

    public void onExit() {
        setState(EXIT);
    }

    public void onResume() {
        setState(RESUME);
    }

    private enum State {

        start, pause, exit, resume
    }
}
