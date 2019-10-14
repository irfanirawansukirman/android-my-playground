package id.co.gits.gitsplayground.view.recyclerviewgroupsticky;

import androidx.annotation.NonNull;

import java.util.Locale;

public class RecyclerviewGroupStickyModel implements Comparable<RecyclerviewGroupStickyModel> {

    private final CharSequence firstName;
    private final CharSequence lastName;
    private static final String NAME_DISPLAY = "%s, %s";

    public RecyclerviewGroupStickyModel(CharSequence firstName, CharSequence lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CharSequence getFirstName() {
        return firstName;
    }

    public CharSequence getLastName() {
        return lastName;
    }

    public String getFullname() {
        return String.format(Locale.getDefault(), NAME_DISPLAY, getLastName(), getFirstName());
    }

    @Override
    public int compareTo(@NonNull RecyclerviewGroupStickyModel recyclerviewGroupStickyModel) {
        return getLastName()
                .toString()
                .compareTo(recyclerviewGroupStickyModel
                        .getLastName()
                        .toString());
    }
}
