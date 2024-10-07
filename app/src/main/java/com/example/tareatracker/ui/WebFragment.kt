package com.example.tareatracker.ui.web

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.tareatracker.databinding.FragmentWebBinding

class WebFragment : Fragment() {

    private var _binding: FragmentWebBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWebBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up WebView with the mouse scrolling fix
        binding.webView.apply {
            webViewClient = WebViewClient()  // Handle page navigation inside the app
            settings.javaScriptEnabled = true  // Enable JavaScript for dynamic web pages
            settings.domStorageEnabled = true // Enable DOM storage for modern websites
            isVerticalScrollBarEnabled = true // Ensure scrollbars are visible
            isScrollContainer = true // Ensure the view is scrollable
            overScrollMode = View.OVER_SCROLL_IF_CONTENT_SCROLLS // Enable overscroll if content exceeds the view
        }

        // Set up the Search button click listener
        binding.loadButton.setOnClickListener {
            val url = binding.urlEditText.text.toString()

            // Ensure the URL has a proper format
            var formattedUrl = url
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                formattedUrl = "https://$url"
            }

            // Load the entered URL
            binding.webView.loadUrl(formattedUrl)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}