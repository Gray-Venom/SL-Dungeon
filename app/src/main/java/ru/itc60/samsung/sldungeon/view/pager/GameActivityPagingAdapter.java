package ru.itc60.samsung.sldungeon.view.pager;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import ru.itc60.samsung.sldungeon.view.fragment.encounter.EncounterFragment;
import ru.itc60.samsung.sldungeon.view.fragment.InventoryFragment;

public class GameActivityPagingAdapter extends FragmentPagerAdapter {

    public GameActivityPagingAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new EncounterFragment();
        }
        return new InventoryFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Событие";
        }
        return "Инвентарь";
    }

}