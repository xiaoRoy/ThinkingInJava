package com.learn.thinking.generic.simplegenerics;

import com.learn.thinking.generic.model.AutoMobile;

public class Holders {

    static class HolderWithExactType {
        private AutoMobile autoMobile;

        public HolderWithExactType(AutoMobile autoMobile) {
            this.autoMobile = autoMobile;
        }

        public AutoMobile getAutoMobile() {
            return autoMobile;
        }
    }

    static class HolderUsingObject {
        private Object content;

        HolderUsingObject(Object content) {
            this.content = content;
        }

        Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }
    }

    static class HolderUsingGeneric<T> {
        private T content;

        public HolderUsingGeneric(T content) {
            this.content = content;
        }

        public T getContent() {
            return content;
        }

        public void setContent(T content) {
            this.content = content;
        }
    }

}
