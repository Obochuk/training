package model.entity;

public class Word {
    private String value;

    public Word(String value) {
        this.value = value;
    }

    public char charAt(int position){
        return value.charAt(position);
    }

    public boolean isEmpty(){
        return value.isEmpty();
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        return value.equals(word.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
