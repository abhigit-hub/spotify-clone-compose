package com.abhigit.spotifyclone.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.abhigit.spotifyclone.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SpotifyViewModel @Inject constructor(): ViewModel() {

    private val _recentPlayedItems: MutableState<List<RecentPlayedItem>> = mutableStateOf(emptyList())
    private val _newReleaseSection: MutableState<TrackItem?> = mutableStateOf(null)
    private val _showSuggestions: MutableState<Shows?> = mutableStateOf(null)
    private val _topMixes: MutableState<TopMixes?> = mutableStateOf(null)
    private val _artists: MutableState<Artists?> = mutableStateOf(null)
    val recentPlayedItems: State<List<RecentPlayedItem>> = _recentPlayedItems
    val newReleaseSection: State<TrackItem?> = _newReleaseSection
    val showSuggestions: State<Shows?> = _showSuggestions
    val topMixes: State<TopMixes?> = _topMixes
    val artists: State<Artists?> = _artists

    init {
        populateRecentPlayedItems()
        populateNewReleaseSection()
        populateShowSuggestionItems()
        populateTopMixesItems()
        populateArtistsItems()
    }

    private fun populateRecentPlayedItems() {
        _recentPlayedItems.value = listOf(
            RecentPlayedItem(
                itemName = "Seedhe Maut",
                itemUrl = "https://i.scdn.co/image/ab67616d0000b2731587397f0ed35797f98ed6a8"
            ),
            RecentPlayedItem(
                itemName = "MF DOOM",
                itemUrl = "https://i.scdn.co/image/ab6761610000e5eb3e9a6caa41a80b9238a49784"
            ),
            RecentPlayedItem(
                itemName = "Eminem Playlist",
                itemUrl = "https://lite-images-i.scdn.co/image/ab67706f000000027a181d9fed936372672c40ca"
            ),
            RecentPlayedItem(
                itemName = "Smokey The Ghost",
                itemUrl = "https://i1.sndcdn.com/artworks-KdvJowDbU526E53g-X7H5OQ-t500x500.jpg"
            ),
            RecentPlayedItem(
                itemName = "Faris Shafi",
                itemUrl = "https://i1.sndcdn.com/artworks-VfJvNyZ1JPIz9cL8-tKDiZQ-t240x240.jpg"
            ),
            RecentPlayedItem(
                itemName = "bollywood slowed x reverb",
                itemUrl = "https://i1.sndcdn.com/artworks-PqTAZz2LbFb48xi8-LJcpmw-t500x500.jpg"
            ),
        )
    }

    private fun populateNewReleaseSection() {
        _newReleaseSection.value = TrackItem(
            artistName = "Smokey The Ghost",
            artistImageUrl = "https://i1.sndcdn.com/artworks-KdvJowDbU526E53g-X7H5OQ-t500x500.jpg",
            albumName = "The Human Nation",
            albumImageUrl = "https://lite-images-i.scdn.co/image/ab67616d0000b273b55943965b29f468c32d842c",
            isLiked = true,
            trackMetaData = "New Release from"
        )
    }

    private fun populateShowSuggestionItems() {
        _showSuggestions.value = Shows(
            shows = listOf(
                ShowItem(
                    showName = "Learn Japanese with Masa sensei",
                    showDescription = "This is the Japanese Grammar Complete Beginner Course that will teach you Japanese Grammar from the scratch. If you would liket to be abe to construct your own sentence by yourself, use Japanese for daily conversation, be independent and able to communicate with the Japanese people, this is the best course for you!\n" +
                            "I will also be talking about the topics that my Patreon supporters requested, as well as some topics about Japanese culture.\n" +
                            "Check out my Youtube Channel!",
                    showImageUrl = "https://i.scdn.co/image/ab67656300005f1fdf7f3cb7c9be374a17c092f7",
                    showLabel = "Education"
                ),
                ShowItem(
                    showName = "Think Fast, Talk Smart: Communication Techniques",
                    showDescription = "Whether you’re giving a toast or presenting in a meeting, communication is critical to success in business and in life. Join Matt Abrahams, a lecturer of Strategic Communication at Stanford Graduate School of Business, as he sits down with experts in the field to discuss real-world challenges.\n" +
                            "\n" +
                            "How do I send my message clearly when put on the spot? How do I write emails to get my point across? How can I easily convey complex information? How do I manage my reputation? \n" +
                            "\n" +
                            "Think Fast, Talk Smart provides the tools, techniques, and best practices to help you communicate more effectively.",
                    showImageUrl = "https://i.scdn.co/image/01fb0a029921e959764ce8b8fa05e68a664a9eec",
                    showLabel = "Business & Technology"
                ),
                ShowItem(
                    showName = "Relaxing Ambiances",
                    showDescription = "I try to provide high-quality ambiance to be used when meditating, practicing mindfulness or just in your everyday life to help you keep calm and relax. I design these primarily using my own recordings.",
                    showImageUrl = "https://i.scdn.co/image/ab67616d0000b27318aee2c98a8792190c68682b",
                    showLabel = "Music"
                ),
                ShowItem(
                    showName = "Stock Market Fundamentals",
                    showDescription = "How to get started in the stock market",
                    showImageUrl = "https://i.scdn.co/image/8fdc729cc9698e605f66b0136973303fc64e8abc",
                    showLabel = "Business"
                ),
                ShowItem(
                    showName = "Woice with Warikoo Podcast",
                    showDescription = "Woice is the official podcast of Ankur Warikoo, where he talks about entrepreneurship, startups, careers and personal growth. Warikoo has been creating video content for the past 4 years across all social media platforms and has a following of 1.7Mn people.\n" +
                            "\n" +
                            "\n" +
                            "Through Woice, he brings his decade long experience as an entrepreneur, as the founder of nearbuy.com, as a public speaker and as an active student of life, risk and failure. ",
                    showImageUrl = "https://i.scdn.co/image/ab6765630000ba8a67c22e654f2f94ace482d61a",
                    showLabel = "Careers"
                ),
                ShowItem(
                    showName = "Conspiracy Theories",
                    showDescription = "The truth is rarely the best story. And when it’s not the only story, the truth deserves another look. Every Wednesday, we tell the complicated stories behind the world’s most controversial events and possible cover-ups. Conspiracy? Maybe. Coincidence? Maybe. Complicated? Absolutely. Conspiracy Theories is a Spotify Original from Parcast.",
                    showImageUrl = "https://i.scdn.co/image/ab6765630000ba8a72dbb66f516b37e4097c2f62",
                    showLabel = "History"
                )
            ),
            showMetaData = "Shows you might like"
        )
    }

    private fun populateTopMixesItems() {
        _topMixes.value = TopMixes(
            topMixes = listOf(
                TopMixesItem(
                    topMixesName = "Smokey The Ghost Mix",
                    topMixesDescription = "MC Bijju, Parimal Shais, Frequency Time Space and more",
                    topMixesImageUrl = "https://i1.sndcdn.com/artworks-KdvJowDbU526E53g-X7H5OQ-t500x500.jpg",
                ),
                TopMixesItem(
                    topMixesName = "CKay Mix",
                    topMixesDescription = "WizKid, Cruel Santino, ZTems and more",
                    topMixesImageUrl = "https://i.scdn.co/image/ab6761610000e5ebea3fa9954a2bbeeb43ba86ae",
                ),
                TopMixesItem(
                    topMixesName = "2000s Mix",
                    topMixesDescription = "MF DOOM, Lil Wayne, The Beatles and more",
                    topMixesImageUrl = "https://i.scdn.co/image/ab6761610000e5eb3e9a6caa41a80b9238a49784",
                ),
                TopMixesItem(
                    topMixesName = "Chill Mix",
                    topMixesDescription = "Whimsical, DripReport, Dax and more",
                    topMixesImageUrl = "https://i.scdn.co/image/ab67616d0000b2738f6c6d7b64d5c656554dcca4",
                ),
                TopMixesItem(
                    topMixesName = "Hip-Hop Mix",
                    topMixesDescription = "Tech N9ne, Kanye West, Jay-Z and more",
                    topMixesImageUrl = "https://i.scdn.co/image/ab67616d0000b27369ca801157537b266dc93873",
                ),
                TopMixesItem(
                    topMixesName = "2010's Mix",
                    topMixesDescription = "Eminem, Kendrick Lamar, J Cole and more",
                    topMixesImageUrl = "https://i.scdn.co/image/ab6761610000e5eb2183ea958d3777d4c485138a",
                ),
                TopMixesItem(
                    topMixesName = "Lofi/Hip-Hop Mix",
                    topMixesDescription = "Powfu, Bazanji and more",
                    topMixesImageUrl = "https://i.scdn.co/image/ab67616d0000b2739549aab58d86eb39fe930f43",
                )
            ),
            topMixesMetaData = "Your top mixes"
        )
    }

    private fun populateArtistsItems() {
        _artists.value = Artists(
            artists = listOf(
                ArtistItem(
                    artistName = "Seedhe Maut",
                    artistImageUrl = "https://i.scdn.co/image/ab67616d0000b2731587397f0ed35797f98ed6a8"
                ),
                ArtistItem(
                    artistName = "Talhah Anjum",
                    artistImageUrl = "https://i.scdn.co/image/ab6761610000e5eb276369b9195d6f67470fd51a"
                ),
                ArtistItem(
                    artistName = "Talhah Yunus",
                    artistImageUrl = "https://i.scdn.co/image/ab6761610000e5ebf69978842bd3102db7611f77"
                ),
                ArtistItem(
                    artistName = "Powfu",
                    artistImageUrl = "https://i.scdn.co/image/ab67616d0000b273bf01fd0986a195d485922167"
                ),
                ArtistItem(
                    artistName = "J. Cole",
                    artistImageUrl = "https://i.scdn.co/image/ab6761610000e5ebadd503b411a712e277895c8a"
                ),
                ArtistItem(
                    artistName = "Prabh Deep",
                    artistImageUrl = "https://lite-images-i.scdn.co/image/ab67616d0000b273accf93bef1c912d3597200cc"
                ),
                ArtistItem(
                    artistName = "MF DOOM",
                    artistImageUrl = "https://i.scdn.co/image/ab67616d0000b273f56213eede5f2e6a6065fb6d"
                ),
                ArtistItem(
                    artistName = "Method Man",
                    artistImageUrl = "https://i.scdn.co/image/60f9c445b2ad379840fa1144faeb0f869cf39dd0"
                ),
                ArtistItem(
                    artistName = "Ol' Burger Beats",
                    artistImageUrl = "https://i.scdn.co/image/ab6761610000e5ebc7932f1798478dc766c4e1eb"
                ),
                ArtistItem(
                    artistName = "Faris Shafi",
                    artistImageUrl = "https://lite-images-i.scdn.co/image/ab67616d0000b273de770a817781ba2cd41ec8b1"
                )
            ),
            artistMetaData = "Your favorite artists"
        )
    }
}