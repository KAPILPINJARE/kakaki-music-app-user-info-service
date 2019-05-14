package com.capgemini.userinfoservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "songDetails")
public class Song {

	@Id
	private int songId;
	private String songTitle;
	private String songUrl;
	private int albumId;
	private String albumName;
	private int artistId;
	private String artistName;
	private String regionName;
	private String songImage;

	public Song() {
		super();
	}

	public Song(int songId, String songTitle, String songUrl, int albumId, String albumName, int artistId,
			String artistName, String regionName, String songImage) {
		super();
		this.songId = songId;
		this.songTitle = songTitle;
		this.songUrl = songUrl;
		this.albumId = albumId;
		this.albumName = albumName;
		this.artistId = artistId;
		this.artistName = artistName;
		this.regionName = regionName;
		this.songImage = songImage;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getSongUrl() {
		return songUrl;
	}

	public void setSongUrl(String songUrl) {
		this.songUrl = songUrl;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getSongImage() {
		return songImage;
	}

	public void setSongImage(String songImage) {
		this.songImage = songImage;
	}

}
