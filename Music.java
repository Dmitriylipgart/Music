package com.lipgart;

import javax.sound.midi.*;

public class Music {

    DrawPanel drawPanel;

    public Music(DrawPanel drawPanel){
        this.drawPanel = drawPanel;
    }

    public void play(){

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] events = {127};
            sequencer.addControllerEventListener(drawPanel, events);

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            for (int i = 5; i < 60; i+= 4) {

                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, i, 100, i + 2));

            }


            sequencer.setSequence(sequence);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }


    }


    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
        MidiEvent event = null;

        try {
            ShortMessage message = new ShortMessage();
            message.setMessage(comd, chan, one, two);
            event = new MidiEvent(message, tick);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }

        return event;
    }

}
