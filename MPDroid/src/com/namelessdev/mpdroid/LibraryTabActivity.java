package com.namelessdev.mpdroid;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class LibraryTabActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Resources res = getResources();
		TabHost tabHost = getTabHost();

		tabHost.addTab(tabHost.newTabSpec("tab_artist").setIndicator(this.getString(R.string.artists),
				res.getDrawable(R.drawable.ic_tab_artists)).setContent(new Intent(LibraryTabActivity.this, ArtistsActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("tab_album").setIndicator(this.getString(R.string.albums),
				res.getDrawable(R.drawable.ic_tab_albums)).setContent(new Intent(LibraryTabActivity.this, AlbumsActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("tab_songs").setIndicator(this.getString(R.string.songs), res.getDrawable(R.drawable.ic_tab_songs))
				.setContent(new Intent(LibraryTabActivity.this, SongSearchMessage.class)));
		tabHost.addTab(tabHost.newTabSpec("tab_files").setIndicator(this.getString(R.string.files),
				res.getDrawable(R.drawable.ic_tab_playlists)).setContent(new Intent(LibraryTabActivity.this, FSActivity.class)));
		((MPDApplication) getApplication()).setActivity(this);
	}

	@Override
	protected void onDestroy() {
		((MPDApplication) getApplication()).setActivity(this);
		super.onDestroy();
	}

}
