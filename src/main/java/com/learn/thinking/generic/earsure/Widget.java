package com.learn.thinking.generic.earsure;

public class Widget {

    public static class WidgetFactory implements IFactory<Widget> {
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}
